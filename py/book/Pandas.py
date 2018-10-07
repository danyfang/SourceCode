import pandas as pd
import numpy as np

dates = pd.date_range('20130101', periods = 6)
df = pd.DataFrame(np.arange(24).reshape((6,4)), index=dates, columns=['A', 'B', 'C', 'D'])

df.iloc[2,2] = 111
print(df)
print('this is test pandas , a data analysis module')
print('this is python 3')

dates = pd.date_range 
a = ['this', 'is', 'awesome']
for b in a:
    print(b)


ts = pd.Series(np.random.randn(1000), index =pd.date_range('1/1/2001', periods=1000))
ts = ts.cumsum()

ts.plot()
