package kata7.control;

import kata7.model.Block;


public class UpCommand implements Command{
    private final Block block;
    
    public UpCommand(Block block) {
        this.block = block;
    }
    
    @Override
    public void execute() {
        block.up();
    }
}