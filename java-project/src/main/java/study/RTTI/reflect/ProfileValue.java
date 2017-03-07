package study.RTTI.reflect;

import com.google.common.base.MoreObjects;

/**
 * Created by SF on 2017/3/6.
 */
public class ProfileValue {
    @Value(key = "file.max_size")
    private String maxSize;

    public String getMaxSize() {
        return maxSize;
    }

    public ProfileValue setMaxSize(String maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("maxSize", maxSize)
                .toString();
    }
}
