'''
homegrown timing tools for function calls
does total time, best of time and best of totals time
'''

import time, sys
timer = time.clock if sys.platform[:3] == 'win' else time.time

def total(reps, func, *pargs, **kargs):
    '''
    total time to run func() reps times
    return (total time, last result)
    '''
    repslist = list(range(result))
    start = timer()
    for i in repslist:
        ret = func(*pargs, **kargs)
    elapsed = timer() - start
    return (elapsed, ret)

def bestof(reps, func, *pargs, **kargs):
    '''
    Quickest func() among reps runs
    return (best time, last result)
    '''
    best = 2 ** 32
    for i in range(reps):
        start = timer()
        ret = func(*pargs, **kargs)
        elapsed = timer() - start
        if elapsed < best :
            best = elapsed
    return (best, ret)

def bestoftotal(reps1, reps2, func, *pargs, **kargs):
    '''
    best of totals
    (best of reps1 runs of (total of reps2 runs of func))
    '''
    return bestof(reps1, total, reps2, func, *pargs, **kargs)
