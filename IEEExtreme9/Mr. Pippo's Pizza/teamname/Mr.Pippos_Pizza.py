def triangles(n):
    if n <= 3:
        return 1
    else:
        m = n-2
    
        res = fact(2*m) // (fact( m + 1) * fact(m))
        return res
    
def fact(n):
    if n<=0:
        return 1
    else:
        x = 1
        for i in range(n):
            x *= i+1
        return x

try:
    for i in range(100):
        x = input()
        if (x != ""):
            x = int(x)
            n = 3
            while (n > 0):
                y = triangles(n)
                if (x == y):
                    print(n)
                    break
                else:
                    n+= 1
        else:
            break
except:
    print("")
