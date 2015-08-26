SOURCES=$(shell find . -iname '*.java')
CLASSES=$(SOURCES:.java=.class)

all: $(CLASSES)

%.class: %.java
	javac -cp $(CLASSPATH) $<

clean:
	echo 'Deleting class files...'
	$(shell find . -iname '*.class' -print -delete)

.PHONY: all clean
