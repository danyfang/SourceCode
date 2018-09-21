## Some exploratory data analysis of the avocado dataset
## https://www.kaggle.com/danyfang/avocado-price/data

# This Python 3 environment comes with many helpful analytics libraries installed
# It is defined by the kaggle/python docker image: https://github.com/kaggle/docker-python
# For example, here's several helpful packages to load in 

import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)
from matplotlib import pyplot as plt

# Input data files are available in the "../input/" directory.
# For example, running this (by clicking run or pressing Shift+Enter) will list the files in the input directory

import os
print(os.listdir("/Users/xuqiang/Desktop"))

# Any results you write to the current directory are saved as output.
avocado = pd.read_csv("/Users/xuqiang/Desktop/avocado.csv")
avocado.describe()
avocado.head()
len(avocado)

PREDICTION_TYPE = 'conventional'
data = avocado[avocado.type == PREDICTION_TYPE]
data.head()
## process date
data['Date'] = pd.to_datetime(data['Date'])
regions = data.groupby(data.region)
REGION = 'TotalUS'
date_price = regions.get_group(REGION)[['Date', 'AveragePrice']].reset_index(drop=True)

date_price.plot(x='Date', y = 'AveragePrice', kind = 'line')
plt.show()
