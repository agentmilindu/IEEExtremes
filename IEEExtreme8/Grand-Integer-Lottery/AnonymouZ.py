def remove_repetitions(seq):
    seen = set()
    seen_add = seen.add
    return [ x for x in seq if not (x in seen or seen_add(x))]

params = input().split()
S = int(params[0])
E = int(params[1])
P = int(params[2])
N = int(params[3])

selects = []
for i in range(N):
    t = input().strip()
    selects.append(t)

LS = []
for i in range(S,E+1):
    for n in selects:
        number = str(i)
        if n in number:
            LS.append(i)

LS.sort()
LS = remove_repetitions(LS)

try:
    print(LS[P-1])
except:
    print("DOES NOT EXIST")
    
        


