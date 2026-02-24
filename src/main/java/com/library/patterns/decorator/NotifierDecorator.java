package com.library.patterns.decorator;

/**
 * Decorator 패턴의 베이스 클래스입니다.
 *
 * <p>원본 Notifier를 감싸고(send 위임),
 * 하위 데코레이터가 부가 기능을 추가할 수 있게 합니다.
 */
public abstract class NotifierDecorator implements Notifier {

    protected final Notifier wrapped;

    protected NotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String send(String message) {
        return wrapped.send(message);
    }
}
