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

@app.route("/register_shipment")
def register_shipment():
    return "register success!"

@app.route("/register_shipping_company")
def regiser_shipping_company():
    return "register success!"

@app.route("/estimate_cost")
def estimate_cost():
    return "$100"   