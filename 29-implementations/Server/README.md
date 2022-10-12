# Simple Web Server

## Quick setup  

First, create conda environment, and install Tornado:

```bash
conda create -n server_api python=3.8
conda install tornado
```

Start the server

```bash
python main.py
```

## Testing 

Put the corresponding URL to a browser and hit enter.

- Random string: `http://localhost:8888/string`
- Simple JSON: `http://localhost:8888/sjson`
- Photo JSON: `http://localhost:8888/pjson`
- Photo JSON V2: `http://localhost:8888/pjsonv2`
- Random MNIST image: `http://localhost:8888/mnist`
- Random cat image: `http://localhost:8888/cat`