#!/bin/python

import httplib, urllib

d = """{"start":"Jan 10, 2011 1:10:00 PM","end":"Jan 10, 2011 2:10:00 PM","name":"studying music","tags":[]}"""

params = urllib.urlencode ({'activity': d})
conn = httplib.HTTPConnection ('localhost:8080')
conn.request ('PUT', '/activity/add', params, {"Content-type": "application/x-www-form-urlencoded"}) 
#conn.request ('PUT', '/activity/add'+ urllib.urlenconde0i
r = conn.getresponse()
print r.status, r.reason
print r.read ()
conn.close ()
