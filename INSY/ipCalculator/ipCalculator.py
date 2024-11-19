import argparse
import ipaddress
import subprocess

userinput = input("Type \"1\" for IPv4-address and \"2\" for a File: ")
print(userinput)
if userinput == "1":
    ip = input("Enter an IPv4 address: ")
elif userinput == "2":
    filename = input("Enter the file name: ")
    try:
        fp = open(filename, "r")
        ip = fp.read()
        fp.close()
        print(ip)
    except IOError:
        print("404: File not found")
elif userinput != "1" and userinput != "2":
    print("Invalid input")
    exit()


ip = ipaddress.ip_network(ip, strict=False)


pingable_host = []
for host in ip.hosts():
    print(host)
    print(f"pinging {host}")
    result = subprocess.run(['ping', '-c', '1', '/w', '0.5', str(host)], stdout=subprocess.DEVNULL,
                            stderr=subprocess.DEVNULL)
    if result.returncode == 0:
        pingable_host.append(host)

fh = open("hosts.txt", "w")
for host in ip.hosts():
    fh.write(str(host) + "\n")

fph = open("pingable_hosts.txt", "w")
for host in pingable_host:
    fph.write(str(host) + "\n")
