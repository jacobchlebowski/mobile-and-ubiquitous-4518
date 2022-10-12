import json
from json import JSONEncoder
import asyncio
import tornado.web
from tornado.log import enable_pretty_logging
import pymongo
from pymongo import MongoClient
from bson.json_util import dumps

cluster = pymongo.MongoClient("mongodb+srv://admin:admin@shoppingcluster.yelm0rl.mongodb.net/?retryWrites=true&w=majority")
db = cluster["Mobile"]
collection = db["Sweatlife"]

enable_pretty_logging()


#  for serializing python objects to JSON 
class MyEncoder(JSONEncoder):
        def default(self, o):
            return o.__dict__



#  a simple handler that returns a JSON string literal 
class SimpleJSONHandler(tornado.web.RequestHandler):
    def get(self):
        # data = {}
        self.set_header('Content-Type', 'application/json') 
        tempData = collection.find()
        data = list(tempData)
        self.write(dumps(data))
    
    def post(self):
        data = {}
        self.set_header('Content-Type', 'application/json')
        data.update(json.loads(self.request.body))
        print(data)
        self.write(json.dumps(data))
        if collection.find_one({"Workout": str(data['Workout'])}) == None:
            collection.insert_one(data)

    def put(self):
        data = {}
        self.set_header('Content-Type', 'application/json')
        data.update(json.loads(self.request.body))
        print(data)
        self.write(json.dumps(data))
        if collection.find_one({"Workout": str(data['Workout'])}) != None:
            collection.delete_one(data)


def make_app():
    return tornado.web.Application([
        (r"/sjson", SimpleJSONHandler),
    ], debug=True, autoreload=True)

#  the web server will listen on the [ADDR] on [PORT] 
async def main():
    app = make_app()
    PORT = 8888
    ADDR = '127.0.0.1'
    app.listen(PORT, ADDR)
    await asyncio.Event().wait()

if __name__ == "__main__":
    asyncio.run(main())