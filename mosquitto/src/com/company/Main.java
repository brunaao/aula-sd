package com.company;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttSubscribe;

import java.text.SimpleDateFormat;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MqttPublishSample publi = new MqttPublishSample("tcp://mqtt.eclipse.org:1883", null, null);
        publi.iniciar();

        new MqttSubSimple(publi, "sensor/temperatura/+", 0);

        while (true) {
            Thread.sleep(1000);
            Random rand = new Random();
            int temp = rand.nextInt(30) + 15;
            String mensagem = temp+"";
            publi.publicar("sensor/temperatura/1", mensagem.getBytes(), 0);
        }
    }
}