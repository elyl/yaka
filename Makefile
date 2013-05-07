NAME=		yaka
JC=		gcj
JFLAGS=		-g -Wall
CLASSPATH=	class
MAIN=		Main
.SUFFIXES:	.java .class
.java.class:
	$(JC) $(JFLAGS) -C -d $(CLASSPATH) $*.java
RM=		@rm -fv
SRC=		Piece.java	\
		PieceCarree.java
CLASSES=	$(SRC:.java=.class)

$(NAME): $(CLASSES)
	$(JC) $(JFLAGS) --classpath $(CLASSPATH) --main=$(MAIN) $(MAIN).java -o $(NAME)

clean:
	$(RM) $(CLASSPATH)/$(CLASSES)

fclean:
	$(RM) $(NAME)

re:	clean fclean $(NAME)