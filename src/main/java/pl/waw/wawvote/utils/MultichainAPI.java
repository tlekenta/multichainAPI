package pl.waw.wawvote.utils;


import com.google.gson.Gson;
import pl.waw.wawvote.model.StreamItem;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
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

    public void subscribeList(String streamName) {
        ShellCommandExecutor obj = new ShellCommandExecutor();
        obj.executeCommand(path + "multichain-cli main_chain2 subscribe " + streamName);
    }

    public void addToChain(String streamName, String key, Integer data) {
        ShellCommandExecutor obj = new ShellCommandExecutor();
        obj.executeCommand(path + "multichain-cli main_chain2 publish " + streamName + " " + key + " " + data);
    }

    public List<Integer> getAllDataFromChain(String streamName) {
        List<Integer> data = new LinkedList<>();
        List<Integer> allData = new LinkedList<>();
        Integer count = 10;
        Integer start = 0;

        do {
            allData.addAll(data);
            data = getSpecificAmountOfData(start, count, streamName);
            start += count;
        }while(data.size() > 0);

        return allData;
    }

    private List<Integer> getSpecificAmountOfData(Integer start, Integer count, String streamName){
        ShellCommandExecutor obj = new ShellCommandExecutor();

        String result = obj.executeCommand(path + "multichain-cli main_chain2 liststreamitems " + streamName + " false " + count + " " + start);

        Gson gson = new Gson();
        StreamItem[] streamItems = gson.fromJson(result, StreamItem[].class);

        return Arrays.stream(streamItems).map(StreamItem::getData).collect(Collectors.toList());
    }

}
