package com.github.ambry.store;

import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class DummyMessageStoreHardDelete implements MessageStoreHardDelete {
  HashMap<Long, MessageInfo> dummyMap;

  public DummyMessageStoreHardDelete(HashMap<Long, MessageInfo> dummyMap) {
    this.dummyMap = dummyMap;
  }

  public DummyMessageStoreHardDelete() {
  }

  @Override
  public Iterator<HardDeleteInfo> getHardDeleteMessages(MessageReadSet readSet, StoreKeyFactory factory,
      List<byte[]> recoveryInfoList) {
    return new Iterator<HardDeleteInfo>() {
      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public HardDeleteInfo next() {
        return null;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  @Override
  public MessageInfo getMessageInfo(Read read, long offset, StoreKeyFactory factory) {
    return dummyMap.get(offset);
  }
}
