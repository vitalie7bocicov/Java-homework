package main;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 *
 * @author vital
 */
public class JSchUtil {

    private String password = "******";

    private ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        jsch.setKnownHosts("/Users/vital/.ssh/known_hosts");
        Session jschSession = jsch.getSession("vitalie.bocicov", "students.info.uaic.ro", 22);
        jschSession.setPassword(password);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    public void uploadFile() throws JSchException, SftpException {
        ChannelSftp channelSftp = setupJsch();
        channelSftp.connect();

        String localFile = "src/main/resources/readme.txt";
        String remoteDir = "pa_test/";

        channelSftp.put(localFile, remoteDir + "readme.txt");

        channelSftp.exit();
    }
}
