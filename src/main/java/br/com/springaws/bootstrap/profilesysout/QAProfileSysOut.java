package br.com.springaws.bootstrap.profilesysout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("qa")
public class QAProfileSysOut {

    @Autowired
    public QAProfileSysOut(@Value("${spring-aws.profile.message}") String msg) {
        System.out.println("##################################");
        System.out.println("##################################");
        System.out.println("##              QA              ##");
        System.out.println("##################################");
        System.out.println("##################################");
    }
}
