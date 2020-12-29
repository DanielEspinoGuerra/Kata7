package kata7.control;

import kata7.model.Block;


public class RightCommand implements Command{
    private final Block block;
    
    public RightCommand(Block block) {
        this.block = block;
    }
    
    @Override
    public void execute() {
        block.right();
    }
}
