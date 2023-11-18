import requests
import random
import string
import math

def get_random_city():
    name = random.choice(string.ascii_lowercase)
    api_url = 'https://api.api-ninjas.com/v1/city?name={}'.format(name)
    response = requests.get(api_url, headers={'X-Api-Key': 'JzAFoInd02hHsFcEHRbHPg==Y2YecUeZRpKLOTFk'}, params={'limit':10})

    return random.choice(response.json())

def get_shipment_location(city_x, city_y):
    x_lat = city_x['latitude']
    x_long = city_x['longitude']

    y_lat = city_y['latitude']
    y_long = city_y['longitude']

    random_lat = random.uniform(min(x_lat, y_lat), max(x_lat, y_lat))
    random_long = random.uniform(min(x_long, y_long), max(x_long, y_long))

    return {'latitude': random_lat, 'longitude': random_long}

def get_shipment_route():
    origin = get_random_city() 
    destination = get_random_city()

    current_loc = get_shipment_location(origin, destination)

    return {"origin" : origin, "destination" : destination, "current_location" : current_loc}

def get_shipment_detail(shipment_id):
    shipment_detail = {}
    shipment_detail["air waybill"] = "160" + '{:0>6}'.format(math.floor(random.random() * 999999 + 0))
    shipment_detail["flight id"] = "CX" + '{:0>3}'.format(math.floor(random.random() * 999 + 0))
    shipment_detail["freight forwarder id"] = random.choice(string.ascii_uppercase) + random.choice(string.ascii_uppercase) + random.choice(string.ascii_uppercase)
    shipment_detail["shipment id"] = '{:0>6}'.format(math.floor(random.random() * 999999 + 0))
    shipment_detail["fragile"] = random.choice([True, False])
    shipment_detail["size (in m)"] = {"length":random.random() * 0.5 + 0.75, "width":random.random() * 0.5 + 0.75, "height":random.random() * 0.5 + 0.75}
    shipment_detail["weight (in kg)"] = random.random() * 10 + 5
    shipment_detail["route"] = get_shipment_route()
    shipment_detail["special notes"] = "None"

    return shipment_detail

print(get_shipment_detail("OJ1035"))