package pl.waw.wawvote;


import pl.waw.wawvote.utils.MultichainAPI;

public class TestClass {

    public static void main(String[] args) {

        MultichainAPI multichainAPI = new MultichainAPI();

        multichainAPI.openNode();
        multichainAPI.subscribeList();
//        multichainAPI.addToChain(112);
//        multichainAPI.addToChain(112);
//        multichainAPI.addToChain(112);
//        multichainAPI.addToChain(112);
//        System.out.println(multichainAPI.getAllVotes());
        System.out.println(multichainAPI.getAllVotes());
    }

}
