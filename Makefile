NAME=		yaka
JC=		javac
JFLAGS=		-g
CLASSPATH=	class
MAIN=		Main
.SUFFIXES:	.java .class
.java.class:
	$(JC) $(JFLAGS) -d $(CLASSPATH) $*.java
RM=		@rm -fv
SRC=		\
		Piece.java		\
		PieceCarree.java	\
		PieceRonde.java		\
		PieceVide.java		\
		Plateau.java		\
		Mouvement.java		\
		Mouvements.java		\
		Coup.java		\
		Joueur.java		\
		JoueurHasardPur.java	\
		Main.java
CLASSES=	$(SRC:.java=.class)

$(NAME): $(CLASSES)

clean:
	$(RM) $(CLASSPATH)/$(CLASSES)

fclean:
	$(RM) $(NAME)

re:	clean fclean $(NAME)