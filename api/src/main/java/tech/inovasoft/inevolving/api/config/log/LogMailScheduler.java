package tech.inovasoft.inevolving.api.config.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.inovasoft.inevolving.api.service.EmailService;
import tech.inovasoft.inevolving.api.service.client.email_service.dto.EmailRequest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Component
public class LogMailScheduler {

    @Autowired
    private EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(LogMailScheduler.class);

    @Scheduled(cron = "0 0 22 ? * SUN") // Domingo às 22h
    public void enviarLogSemanal() {
        String caminho = "target/logs/app.log";
        File logFile = new File(caminho);

        if (logFile.exists()) {
            try {
                byte[] logBytes = Files.readAllBytes(logFile.toPath());
                String conteudo = new String(logBytes, StandardCharsets.UTF_8);

                 emailService.sendEmail(new EmailRequest("adm@inovasoft.tech", "Log Semanal - InEvolving", conteudo));

                logger.info("Log enviado com sucesso.");
            } catch (IOException e) {
                logger.error("Erro ao ler o arquivo de log", e);
            }
        } else {
            logger.warn("Arquivo de log não encontrado no momento do envio.");
        }
    }
}
