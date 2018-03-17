package pl.waw.wawvote.utils;


import com.google.gson.Gson;
import pl.waw.wawvote.model.StreamItem;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultichainAPI {
    private static String path = new File("").getAbsolutePath() + "\\multichain-windows-1.0.4\\";

    public void openNode() {
        System.out.println("Opening node");
        new Thread(() -> {
            ShellCommandExecutor obj = new ShellCommandExecutor();
            obj.executeCommand(path + "multichaind main_chain2 -deamon");
        }).start();
        System.out.println("Node opened");
    }

    public void subscribeList() {
        ShellCommandExecutor obj = new ShellCommandExecutor();
        obj.executeCommand(path + "multichain-cli main_chain2 subscribe stream1");
    }

    public void addToChain(Integer vote) {
        //publish stream1 key1 736f6d65206f746865722064617461
        ShellCommandExecutor obj = new ShellCommandExecutor();
        obj.executeCommand(path + "multichain-cli main_chain2 publish stream1 key1 0" + vote);
    }

    public List<Integer> getAllVotes() {
        ShellCommandExecutor obj = new ShellCommandExecutor();
        String result = obj.executeCommand(path + "multichain-cli main_chain2 liststreamitems stream1");

        Gson gson = new Gson();
        StreamItem[] streamItems = gson.fromJson(result, StreamItem[].class);


        return Arrays.stream(streamItems).map(StreamItem::getData).collect(Collectors.toList());
    }

}
