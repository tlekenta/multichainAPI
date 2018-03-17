package pl.waw.wawvote;


import pl.waw.wawvote.utils.MultichainAPI;

public class TestClass {

    public static void main(String[] args) {

        MultichainAPI multichainAPI = new MultichainAPI();

        multichainAPI.openNode();
        multichainAPI.subscribeList("stream1");
        System.out.println(multichainAPI.getAllDataFromChain("stream1"));
    }

}
