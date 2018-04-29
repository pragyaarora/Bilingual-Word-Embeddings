
# coding: utf-8

# In[25]:

with open('C:/Users/pragya/cl2 project/inuk_sent_data', 'r') as file:
    i=0
    morph_dict = set()
    for line in file:
        morphs = line.strip().split(' ')
        for m in morphs:
            morph_dict.add(m)


# In[26]:

len(morph_dict)


# In[34]:

import re
dict_file_1 = open('C:/Users/pragya/cl2 project/dictionary/inuk_dictionary_1', 'w')
dict_file_3 = open('C:/Users/pragya/cl2 project/dictionary/inuk_dictionary_3', 'w')
dict_file_o = open('C:/Users/pragya/cl2 project/dictionary/inuk_dictionary_o', 'w')
with open('C:/Users/pragya/cl2 project/dictionary/roots.en.txt', 'r') as file:
    for line in file:
        line = re.sub('\s\s+','\t',line)
        words = line.split('\t')
        word = words[0].split("/")[0]
        if word in morph_dict:
            meaning = words[1]
            if len(meaning.split(' '))==1:
                dict_file_1.write(word+'\t'+meaning)
            elif len(meaning.split(' '))<4:
                dict_file_3.write(word+'\t'+meaning)
            else:
                dict_file_o.write(word+'\t'+meaning)
            
dict_file_1.close()
dict_file_3.close()
dict_file_o.close()

