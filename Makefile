#Flags
JFLAGS = -g --release 11
JC = javac 

#Source files
SOURCES = Matrix.java

#Class Files
CLASSES =  $(SOURCES:.java=.class)

#default make target : Compile and run
default: run

#Rule to compile
%.class: %.java 
	$(JC) $(JFLAGS) $<

#target to build
classes: $(CLASSES)	

#run program
run: classes	
	java Matrix

clean:
	$(RM) $(CLASSES)
