from flask import Flask
from flask import request
from shipment import get_shipment_detail

app = Flask(__name__)

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

@app.route("/track_shipment/<shipment_id>")
def track_shipment(shipment_id):
    return get_shipment_detail(shipment_id)

