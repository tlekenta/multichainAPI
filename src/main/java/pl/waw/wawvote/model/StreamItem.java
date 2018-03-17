package pl.waw.wawvote.model;

public class StreamItem {
    String[] publishers;
    String key;
    Integer data;
    Integer confirmations;
    Integer blocktime;
    String txid;

    public String[] getPublishers() {
        return publishers;
    }

    public void setPublishers(String[] publishers) {
        this.publishers = publishers;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Integer getBlocktime() {
        return blocktime;
    }

    public void setBlocktime(Integer blocktime) {
        this.blocktime = blocktime;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }
}
