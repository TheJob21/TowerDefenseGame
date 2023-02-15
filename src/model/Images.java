package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    public static BufferedImage STAP1;
    public static BufferedImage STAP2;
    public static BufferedImage ATT1;
    public static BufferedImage ATT2;
    public static BufferedImage MTT1;
    public static BufferedImage MTT2;
    public static BufferedImage Ghost1;
    public static BufferedImage Ghost2;
    public static BufferedImage Banshee1;
    public static BufferedImage Banshee2;
    public static BufferedImage Wraith1;
    public static BufferedImage Wraith2;
    public static BufferedImage Park;
    public static BufferedImage McDaniel;
    public static BufferedImage Qian;
    public static BufferedImage Sung;
    public static BufferedImage Turner;
    public static BufferedImage Ladan;

    public Images(){
        try{
            ATT1 = ImageIO.read(new File("../TermProject/src/Images/ATT1.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            ATT2 = ImageIO.read(new File("../TermProject/src/Images/ATT2.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            MTT1 = ImageIO.read(new File("../TermProject/src/Images/MTT1.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            MTT2 = ImageIO.read(new File("../TermProject/src/Images/MTT2.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            STAP1 = ImageIO.read(new File("../TermProject/src/Images/STAP1.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            STAP2 = ImageIO.read(new File("../TermProject/src/Images/STAP2.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Ghost1 = ImageIO.read(new File("../TermProject/src/Images/ghost1.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Ghost2 = ImageIO.read(new File("../TermProject/src/Images/ghost2.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Banshee1 = ImageIO.read(new File("../TermProject/src/Images/banshee1.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Banshee2 = ImageIO.read(new File("../TermProject/src/Images/banshee2.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Wraith1 = ImageIO.read(new File("../TermProject/src/Images/wraith1.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Wraith2 = ImageIO.read(new File("../TermProject/src/Images/wraith2.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Park = ImageIO.read(new File("../TermProject/src/Images/ParkFace.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            McDaniel = ImageIO.read(new File("../TermProject/src/Images/McDanielFace.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Qian = ImageIO.read(new File("../TermProject/src/Images/QianFace.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Sung = ImageIO.read(new File("../TermProject/src/Images/SungFace.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Turner = ImageIO.read(new File("../TermProject/src/Images/TurnerFace.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Ladan = ImageIO.read(new File("../TermProject/src/Images/Ladan.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
