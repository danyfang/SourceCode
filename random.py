import random
def single_prob(p):
   if random.random() < p:
       return 0
   return 1
def bias_prob_generator(p):
   if p > 0.5:
       if single_prob(0.5) == 1:
           return 1
       else:
           return to_equal(1 - 2*(1-p))
   else:
       if single_prob(0.5) == 0:
           return 0
       else:
           return to_equal(2*p)

zero_cnt = 0
one_cnt = 0
for i in range(100000):
   r = bias_prob_generator(0.7)
   if r == 1:
       one_cnt += 1
   else:
       zero_cnt += 1


print("0's: %d, 1's: %d" % (zero_cnt, one_cnt))
