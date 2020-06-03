all: run

clean:
	rm -f src/*.class out/Solovey.jar

Solovey.jar: out/parcs.jar src/*.java
	@javac -cp out/parcs.jar src/*.java
	@jar cf out/Solovey.jar -C src .
	@rm -f src/*.class

run: Solovey.jar
	@cd out && java -cp 'parcs.jar:Solovey.jar' Solovey