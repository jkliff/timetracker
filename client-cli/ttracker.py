#!/usr/local/bin/python2.7

import yaml
import os.path
from argparse import ArgumentParser
import urllib2
import re

sanitize_url = lambda x: 'http://' + re.sub ('\/+', '/', re.sub ('(http://)(.*)', '\g<2>', x))

def generate_action (action_path, http_method):
    """generates a function capable of submitting rest requests to the server"""
    def f (config, msg):
        r = ()
        host = config ['server_base_url']
        v = '%s/%s' % (host, action_path) 
        v = sanitize_url (v)
        req = urllib2.urlopen (v)

        return r
    return f

ACTIONS = {
    'add': generate_action ('/activity/add', 'PUT'),
    'stop': generate_action ('/activity/stop', ''),
    'list': generate_action ('/activity/list', 'GET'),
    'status': generate_action ('/status', 'GET')
}

def _setup_argument_parser ():

    p = ArgumentParser (description = """timetracker command-line client.""")
    p.add_argument ('-a', '--action', choices = ACTIONS.keys(), dest='action', help='Action to be executed')
    p.add_argument ('-m', '--message', dest = 'message', help='message to add', metavar =  'MSG')
    p.add_argument ('-c', '--config', dest = 'config', default = '~/.timetracker.conf', help='configuration', metavar = 'CONFIG_PATH')
    return p

_npath = lambda p: os.path.abspath (os.path.expanduser (p))

def main ():
    p = _setup_argument_parser ()
    args = p.parse_args()

    action = args.action
    message = args.message
    config_path = _npath (args.config)

    if action is None:
        print ("""I can't read your mind.""")
        exit (-1)

    #checks we have configuration avaliable at the right place (overriden or default)
    if config_path is None or not os.path.exists (config_path):
        print ('Configuration could not be found at %s' % config_path)
        exit (-2)
    else:
        # try to load yaml from specified path
        config = {}
        with (open (config_path, 'r')) as f:
            config = yaml.load (f.read ())

        print config 

    # performs action
    global ACTIONS
    ACTIONS [action] (config, message)

if __name__ == '__main__':
    main ()
