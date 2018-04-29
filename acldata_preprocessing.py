
# coding: utf-8

# In[ ]:

def parseMorph(x):
    x = x.replace('}{', ' ')
    x = x.replace('{', '')
    x = x.replace('}', '')
    y = x.split()
    res = []
    for word in y : 
        start = word.index(':')
        end = word.index('/')
        res.append(word[start+1:end])
        
    return ' '.join(res)


# In[ ]:

with open('inuk_morph_all.txt', 'r') as file:
    lines = []
    morph_dict = dict()
    morpheme_dict = dict()
    for line in file:
        if line != '\n':
            line = line.strip().lower()
            if line[0]=='{':
                morph_seg = parseMorph(line)
                morph_dict[morph_seg] = morph_dict.get(morph_seg,0)+1
            else:
                morph = line
        else:
            if len(morph_dict.keys()) > 0:
                morpheme_dict[morph] = max(morph_dict.keys(), key=(lambda key: morph_dict[key]))
            else:
                morpheme_dict[morph] = morph
            morph_dict = dict()
    if len(morph_dict.keys()) > 0:
        morpheme_dict[morph] = max(morph_dict.keys(), key=(lambda key: morph_dict[key]))
    else:
        morpheme_dict[morph] = morph


# In[ ]:

print(len(morpheme_dict.keys()))


# In[ ]:

import numpy as np
np.save('morph_dict.npy',morpheme_dict)


# In[ ]:

morpheme_dict['iqaluit']


# In[ ]:

import re
import string
regex = re.compile('[%s]' % re.escape(string.punctuation))

def read_all_sentences(file):
    with open(file,'r') as f:
        sent = []
        for line in f:
            line = regex.sub('', line)
            line = re.sub('[0-9]+', '', line)
            line = line.strip()
            sent.append(line.lower())
            
    return sent

sent = read_all_sentences('SentenceAligned.v1_1.txt.i')


# In[ ]:

with open('inuk_sent_data', 'w') as f:
    for line in sent :
        words = line.split()
        for word in words : 
            if word in morpheme_dict.keys():
                f.write(morpheme_dict[word] + ' ')
                continue
            else:
                f.write(word + ' ')
                morpheme_dict[word] = word
        f.write('\n')


# In[ ]:

sent = read_all_sentences('eng_sent.e')
with open('eng_sent_data', 'w') as file:
    for s in sent:
        file.write(s+'\n')

