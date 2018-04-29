import numpy as np
import heapq
import operator
import random
import sys

def read_embeddings(filename):
    embeddings = dict()
    with open(filename) as f:
        lines = f.readlines()[1:]
    for line in lines:
        parts = line.strip().split(' ')
        word = parts[0]
        vector = [float(w) for w in parts[1:]]
        embeddings[word] = np.array(vector)
    return embeddings

def similarity(vec1, vec2):
    return np.dot(vec1, vec2)/(np.linalg.norm(vec1)*np.linalg.norm(vec2)+1e-10)

def get_best_emb(embeddings, test_emb):
    scores = []
    for (k, v) in embeddings.items():
        sim = similarity(v, test_emb)
        scores.append((k, sim))
    return heapq.nlargest(20, scores, operator.itemgetter(1))

def main(argv):
    eng_emb = read_embeddings(argv[0])
    in_emb = read_embeddings(argv[1])
    count = 0
    total = 0
    not_found = 0
    flag = ((argv[2]) == 'True')
    print(flag)
    with open('./dictionary/inuk_dictionary', 'r') as file:
        for line in file:
            words = line.split('\t')
            if words[0] in in_emb.keys():
                matches = get_best_emb(eng_emb, in_emb[words[0]])
                meaning = words[1].strip()
                found = False
                for e_w, sim in matches:
                    if e_w in meaning:
                        found = True
                        break
                if found:
                    count += 1
                else:
                    if flag:
                        if ',' in meaning:
                            meaning = meaning.split(',')[0]
                        if meaning in eng_emb.keys():
                            for e_w, sim in matches:
                                sim = similarity(eng_emb[e_w],eng_emb[meaning])
                                if sim > 0.99:
                                    print("e_w : " + e_w + " meaning : " + meaning)
                                    count += 1
                                    break
                total += 1
            else:
                not_found += 1

    print(count/total)
    print(not_found)

if __name__ == "__main__":
    main(sys.argv[1:])
