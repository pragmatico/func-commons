[![Build Status](https://travis-ci.org/pragmatico/func-commons.svg?branch=master)](https://travis-ci.org/pragmatico/func-commons)
[![codecov.io](https://codecov.io/github/pragmatico/func-commons/coverage.svg?branch=master)](https://codecov.io/github/pragmatico/func-commons?branch=master)

# func-commons
Java 8 common library with extra functions, samples and experiments


Collection of "less" functional interfaces that throw exceptions (checked and unchecked)

Functional interfaces throwing checked exceptions

+ ThrowingBiConsumer
+ ThrowingBiFunction
+ ThrowingConsumer
+ ThrowingFunction
+ ThrowingPredicate
+ ThrowingSupplier

Functional interfaces throwing unchecked exceptions

+ UncheckedBiConsumer
+ UncheckedBiFunction
+ UncheckedConsumer
+ UncheckedFunction
+ UncheckedPredicate
+ UncheckedSupplier

----

Repository with snapshots:

	<repositories>
	    <repository>
	        <id>oss-sonatype</id>
	        <name>oss-sonatype</name>
	        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
	        <snapshots>
	            <enabled>true</enabled>
	        </snapshots>
	    </repository>
	</repositories>