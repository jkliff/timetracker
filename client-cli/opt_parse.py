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

def report_wrong_action ():
    print 'Unsupported operation'

p = ArgumentParser (description = """timetracker command-line client.""")
p.add_argument ('-a', '--action', choices = ACTIONS.keys(), dest='action', help='Action to be executed')
p.add_argument ('-m', '--message', dest = 'message', help='message to add', metavar =  'MSG')

args = p.parse_args()
print args
action = args.action
message = args.message

print action, message

if action is None:
    print ("""I can't read your mind.""")
    exit (-1)

print 'Will do', action


