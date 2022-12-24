# CryptoFX
## A JavaFX Application to display live crypto prices. 

<img alt="HMC" src="demo.png" />

## ⚙️ Dependencies / module-info

```java
module Crypto {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.json;
	opens application to javafx.graphics, javafx.fxml;
}
```
