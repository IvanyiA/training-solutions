package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return mails;
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> findByCriteria(String searchText) {
        List<Mail> filtered = new ArrayList<>();

        if (searchText.contains(":")) {
            String[] parts = searchText.split(":");
            String key = parts[0];
            String value = parts[1];

            for (Mail mail : mails) {
                findByTo(filtered, key, value, mail);
                findByFrom(filtered, key, value, mail);
            }
        }
        findBySubjectOrMessage(searchText, filtered);
        return filtered;
    }

    private void findBySubjectOrMessage(String searchText, List<Mail> filtered) {
        for (Mail mail : mails) {
            if (mail.getMessage().contains(searchText) || mail.getSubject().contains(searchText)) {
                filtered.add(mail);
            }
        }
    }

    private void findByFrom(List<Mail> filtered, String key, String value, Mail mail) {
        if (key.startsWith("from")) {
            if (mail.getFrom().getName().equals(value) ||
                    mail.getFrom().getEmail().startsWith(value))
                filtered.add(mail);
        }
    }

    private void findByTo(List<Mail> filtered, String key, String value, Mail mail) {
        if (key.startsWith("to")) {
            for (Contact contact : mail.getTo())
                if (contact.getName().contains(value))
                    filtered.add(mail);
        }
    }

}
