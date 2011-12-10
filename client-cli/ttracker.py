#!/usr/bin/python

from argparse import ArgumentParser

def generate_action (action):
    """generates a function capable of submitting rest requests to the server"""
    pass

ACTIONS = {
    'add': generate_action ('add'),
    'stop': generate_action ('stop'),
    'list': generate_action ('list'),
    'status': generate_action ('status')
}

def _execute ():
    """here we execute the operation. we build here the connection as to delay it as most as possible"""
    #validate parameters

    #open connection
    #send request
    result = ()
    #close
    return result

def insert ():
    #build request for current date
    #send request
    #check it is all ok

    pass

def finish_current ():
    pass

def view ():
    pass

def check ():
    """send a probe to the server. useful to check if it is reacheble and rightly configured"""
    pass

def report_wrong_action ():
    print 'Unsupported operation'

def setup_argument_parser ():

    p = ArgumentParser (description = """timetracker command-line client.""")
    p.add_argument ('-a', '--action', choices = ACTIONS.keys(), dest='action', help='Action to be executed')
    p.add_argument ('-m', '--message', dest = 'message', help='message to add', metavar =  'MSG')
    return p

def main ():
    p = setup_argument_parser ()
    args = p.parse_args()
    print args
    action = args.action
    message = args.message
    
    print action, message
    
    if action is None:
        print ("""I can't read your mind.""")
        exit (-1)
    
    print 'Will do', action

    #checks we have configuration avaliable at the right place (overriden or default)

if __name__ == '__main__':
    main ()
