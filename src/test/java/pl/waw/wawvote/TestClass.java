package pl.waw.wawvote;


import pl.waw.wawvote.utils.MultichainAPI;

public class TestClass {

    public static void main(String[] args) {

        MultichainAPI multichainAPI = new MultichainAPI();

        multichainAPI.openNode();
        multichainAPI.subscribeList();
        System.out.println(multichainAPI.getAllVotes());
        multichainAPI.addToChain(112);
        multichainAPI.addToChain(112);
        multichainAPI.addToChain(112);
        multichainAPI.addToChain(112);
        System.out.println(multichainAPI.getAllVotes());
    }

}
