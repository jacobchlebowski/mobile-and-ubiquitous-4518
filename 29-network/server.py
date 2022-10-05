
import json
from json import JSONEncoder
import asyncio
import tornado.web
from tornado.log import enable_pretty_logging

enable_pretty_logging()

data = {}

#  for serializing python objects to JSON 
class MyEncoder(JSONEncoder):
        def default(self, o):
            return o.__dict__



#  a simple handler that returns a JSON string literal 
class SimpleJSONHandler(tornado.web.RequestHandler):
    def get(self):
        self.set_header('Content-Type', 'application/json') 
        self.write(json.dumps(data))
    
    def post(self):
        self.set_header('Content-Type', 'application/json')
        data.update(json.loads(self.request.body))
        print(data)
        self.write(json.dumps(data))
    
    def put(self):
        self.set_header('Content-Type', 'application/json')
        print(data)
        data.update(json.loads(self.request.body))
        self.write(json.dumps(data))

    def delete(self):
        self.set_header('Content-Type', 'application/json')
        print(data)
        data.pop("color")
        self.write(json.dumps(data))


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