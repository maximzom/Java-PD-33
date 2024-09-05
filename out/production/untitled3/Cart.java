����   B c
      java/lang/Object <init> ()V  java/util/ArrayList
  	      Cart products Ljava/util/List;      java/util/List add (Ljava/lang/Object;)Z     remove     iterator ()Ljava/util/Iterator;     ! " java/util/Iterator hasNext ()Z  $ % & next ()Ljava/lang/Object; ( Product
 ' * + , getPrice ()D . java/lang/StringBuilder 0 Кошик містить:

 - 2  3 (Ljava/lang/String;)V
 ' 5 6 7 toString ()Ljava/lang/String;
 - 9 : ; append -(Ljava/lang/String;)Ljava/lang/StringBuilder; = 
 ? #Загальна вартість: 
  A B , getTotalPrice
 - D : E (D)Ljava/lang/StringBuilder;
 - 5
  H  I (Ljava/util/Collection;)V  K L  clear 	Signature Ljava/util/List<LProduct;>; Code LineNumberTable LocalVariableTable this LCart; 
addProduct (LProduct;)V product 	LProduct; removeProduct total D StackMapTable sb Ljava/lang/StringBuilder; getProducts ()Ljava/util/List; ()Ljava/util/List<LProduct;>; 
SourceFile 	Cart.java !          M    N      O   B     *� *� Y� 	� 
�    P         	  
 Q        R S    T U  O   D     *� 
+�  W�    P   
       Q        R S      V W   X U  O   D     *� 
+�  W�    P   
       Q        R S      V W   B ,  O   �     -H*� 
�  N-�  � -� # � ':'� )cH���'�    P             (  +  Q         V W    - R S    + Y Z  [    �  �   6 7  O   �     K� -Y/� 1L*� 
�  M,�  � ,� # � 'N+-� 4� 8<� 8W���+>� 8*� @� CW+� F�    P       " 
 # ' $ 5 % 8 & F ' Q      '  V W    K R S   
 A \ ]  [    �  - � #  ^ _  O   6     � Y*� 
� G�    P       + Q        R S   M    `  L   O   8     
*� 
� J �    P   
    / 	 0 Q       
 R S    a    b