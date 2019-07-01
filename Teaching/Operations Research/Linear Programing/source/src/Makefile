SYSTEM     = x86-64_linux
LIBFORMAT  = static_pic

#------------------------------------------------------------
#
# When you adapt this makefile to compile your CPLEX programs
# please copy this makefile and set CPLEXDIR and CONCERTDIR to
# the directories where CPLEX and CONCERT are installed.
#
#------------------------------------------------------------

CPLEXDIR      = /opt/ibm/ILOG/CPLEX_Studio126/cplex
CONCERTDIR    = /opt/ibm/ILOG/CPLEX_Studio126/concert
# ---------------------------------------------------------------------
# Compiler selection 
# ---------------------------------------------------------------------
JAVAC = javac 

# ---------------------------------------------------------------------
# Compiler options 
# ---------------------------------------------------------------------
JOPT  = -classpath $(CPLEXDIR)/lib/cplex.jar -O

# ---------------------------------------------------------------------
# Link options and libraries
# ---------------------------------------------------------------------

CPLEXBINDIR   = $(CPLEXDIR)/bin/$(BINDIST)
CPLEXJARDIR   = $(CPLEXDIR)/lib/cplex.jar

JAVA      = java  -d64 -Djava.library.path=$(CPLEXDIR)/bin/x86-64_linux -classpath $(CPLEXJARDIR):


all:
	make all_java

execute: all
	make execute_java

EXDIR         = /home/userX  #replace the X for your userid
EXSRCJAVA     = $(EXDIR)
JCFLAGS = $(JOPT)


#------------------------------------------------------------
#  make all      : to compile the examples. 
#  make execute  : to compile and execute the examples.
#------------------------------------------------------------


JAVA_EX = happiness.class 

all_java: $(JAVA_EX)

execute_java: $(JAVA_EX)
	 $(JAVA) Happiness 

happiness.class: $(EXSRCJAVA)/Happiness.java
	$(JAVAC) $(JCFLAGS) -d . $(EXSRCJAVA)/Happiness.java 



# Local Variables:
# mode: makefile
# End:
