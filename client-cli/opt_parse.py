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

