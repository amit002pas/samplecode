import sys
def returnvalue(arg) :
    if arg == "hi" :
        return "yes"
    return "no"
print("calling python function with parameters:")
print(sys.argv[1])
arg = sys.argv[1]
res = returnvalue(arg)
print(res)
