import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import GaussianNB
from sklearn.pipeline import Pipeline
from nltk.corpus import stopwords
import string
from sklearn.preprocessing import LabelEncoder
from sklearn.metrics import classification_report, confusion_matrix
from sklearn.neighbors import KNeighborsClassifier


movie = pd.read_csv('/Users/xuqiang/Desktop/movie/spam.csv')

def process_text(text):
    '''
    What will be covered:
    1. Remove punctuation
    2. Remove stopwords
    3. Return list of clean text words
    '''
    #1
    nopunc = [char for char in text if char not in string.punctuation]
    nopunc = ''.join(nopunc)
    #2
    clean_words = [word for word in nopunc.split() if word.lower() not in stopwords.words('english')]
    #3
    return clean_words

movie.data.apply(process_text)
tfidf = TfidfVectorizer()

X = TfidfVectorizer().fit_transform(movie.data).todense()
y = LabelEncoder().fit_transform(movie.target)

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.25, random_state = None)
print('The length of train size : ', len(X_train))
clf = GaussianNB()
clf.fit(X_train, y_train)

pred = clf.predict(X_test)
print(classification_report(pred, y_test))
print(confusion_matrix(y_test, pred))

clf = KNeighborsClassifier(n_neighbors = 20)
clf.fit(X_train, y_train)

pred = clf.predict(X_test)
print(classification_report(pred, y_test))
print(confusion_matrix(y_test, pred))
