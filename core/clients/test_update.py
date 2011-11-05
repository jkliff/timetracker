#!/bin/python

import httplib, urllib

d = """{"id": 1, "start":"Jan 10, 2011 1:10:00 PM","end":"Jan 10, 2011 2:10:00 PM","name":"studying music updated","tags":[]}"""

params = urllib.urlencode ({'activity': d})
conn = httplib.HTTPConnection ('localhost:8080')
conn.request ('POST', '/activity/update', params, {"Content-type": "application/x-www-form-urlencoded"}) 
r = conn.getresponse()
print r.status, r.reason
print r.read ()
conn.close ()
