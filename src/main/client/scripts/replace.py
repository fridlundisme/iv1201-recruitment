fin = open("migrate.sql", "rt")
fout = open("out.sql","wt")
for line in fin:
    fout.write(line.replace("’", "'"))
fin.close()
fout.close()