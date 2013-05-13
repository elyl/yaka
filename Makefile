NAME=		yaka
JC=		gcj
JFLAGS=		-g -Wall
CLASSPATH=	class
MAIN=		Main
.SUFFIXES:	.java .class
.java.class:
	$(JC) $(JFLAGS) -C -d $(CLASSPATH) $*.java
RM=		@rm -fv
SRC=		\
		Piece.java		\
		PieceCarree.java	\
		PieceRonde.java		\
		PieceVide.java		\
		Plateau.java		\
		Mouvement.java		\
		Mouvements.java		\
		Main.java
CLASSES=	$(SRC:.java=.class)

$(NAME): $(CLASSES)
	$(JC) $(JFLAGS) -I $(CLASSPATH) $(CLASSPATH)/*.class --main=$(MAIN) -o $(NAME)

clean:
	$(RM) $(CLASSPATH)/$(CLASSES)

fclean:
	$(RM) $(NAME)

re:	clean fclean $(NAME)