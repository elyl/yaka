NAME=		yaka
JAR_NAME=	lheureux-bergeron
JC=		gcj
JFLAGS=		-g -Wall --sourcepath $(SOURCEPATH)
CLASSPATH=	class
SOURCEPATH=	src
MAIN=		Main
JAR=		gjar
JDOC=		gjdoc
JDOC_PATH=	doc
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
		Joueur.java		\
		JoueurHasardPur.java	\
		Coup.java		\
		Main.java

CLASSES=	$(SRC:.java=.class)

$(NAME): $(CLASSES)
	$(JC) $(JFLAGS) -I $(CLASSPATH) $(CLASSPATH)/*.class --main=$(MAIN) -o $(NAME)

all: $(NAME) jdoc jar

clean:
	$(RM) $(CLASSPATH)/$(CLASSES)

fclean:
	$(RM) $(NAME)

jdoc:
	$(JDOC) $(SRC) -d $(JDOC_PATH)

jar:
	$(JAR) cf $(JAR_NAME).jar $(SRC) $(JDOC_PATH)

re:	clean fclean $(NAME)