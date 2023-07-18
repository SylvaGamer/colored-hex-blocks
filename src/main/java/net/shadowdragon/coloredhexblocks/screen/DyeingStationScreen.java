package net.shadowdragon.coloredhexblocks.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shadowdragon.coloredhexblocks.ColoredHexBlocks;
import net.shadowdragon.coloredhexblocks.networking.HexMessages;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.glfw.GLFW;



public class DyeingStationScreen extends HandledScreen<DyeingStationScreenHandler> {
    public static boolean isValid1 = true;
    public static boolean isValid2 = true;
    public static boolean isValid3 = true;
    private static final Identifier TEXTURE =
            new Identifier(ColoredHexBlocks.MOD_ID, "textures/gui/dyeing_station_gui.png");

    private TextFieldWidget redField;
    private TextFieldWidget greenField;
    private TextFieldWidget blueField;

    private int color;
    private int redColor = 0;
    private int blueColor = 0;
    private int greenColor = 0;


    @Override
    protected void handledScreenTick() {
        this.redField.tick();
        this.greenField.tick();
        this.blueField.tick();
        super.handledScreenTick();
    }

    public DyeingStationScreen(DyeingStationScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }


    public static boolean isNumeric(String string) {

        int intValue;
        //System.out.println(String.format("Parsing string: \"%s\"", string));
        if (string == null || string.equals("")) {
            //System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            //System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    @Override
    protected void init() {
        super.init();
        titleY = 5;
        playerInventoryTitleY = 73;
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        this.redField = new TextFieldWidget(this.textRenderer, i+23, j+39, 28, 7,
                Text.translatable("structure_block.position.x"));
        this.redField.setMaxLength(3);
        this.redField.setEditableColor(-1);
        this.redField.setUneditableColor(-1);
        this.redField.setDrawsBackground(false);
        this.redField.setText("");
        this.redField.setPlaceholder(Text.literal("0"));
        //System.out.println(String.valueOf(redColor) + "string");
        this.redField.setChangedListener(this::onChanged);
        this.addSelectableChild(this.redField);


        this.greenField = new TextFieldWidget(this.textRenderer, i+23, j+50, 28, 7,
                Text.translatable("structure_block.position.x"));
        this.greenField.setMaxLength(3);
        this.greenField.setEditableColor(-1);
        this.greenField.setUneditableColor(-1);
        this.greenField.setDrawsBackground(false);
        this.greenField.setText("");
        this.greenField.setPlaceholder(Text.literal("0"));
        //System.out.println(String.valueOf(greenColor) + "string");
        this.greenField.setChangedListener(this::onChanged);
        this.addSelectableChild(this.greenField);


        this.blueField = new TextFieldWidget(this.textRenderer, i+ 23, j+61, 28, 7,
                Text.translatable("structure_block.position.x"));
        this.blueField.setMaxLength(3);
        this.blueField.setEditableColor(-1);
        this.blueField.setUneditableColor(-1);
        this.blueField.setDrawsBackground(false);
        this.blueField.setText("");
        this.blueField.setPlaceholder(Text.literal("0"));
        //System.out.println(String.valueOf(blueColor) + "string");
        this.blueField.setChangedListener(this::onChanged);
        this.addSelectableChild(this.blueField);

    }

    private void onChanged(String field) {

        if(StringUtils.isNumeric(this.redField.getText())){
            redColor = Integer.parseInt(this.redField.getText());
            isValid1 = redColor <= 255;

        } else{
            isValid1 = false;
        }

        if(StringUtils.isNumeric(this.greenField.getText())) {
            greenColor = Integer.parseInt(this.greenField.getText());
            isValid2 = greenColor <= 255;

        } else{
            isValid2 = false;
        }

        if(StringUtils.isNumeric(this.blueField.getText())) {
            blueColor = Integer.parseInt(this.blueField.getText());
            isValid3 = blueColor <= 255;
        } else{
            isValid3 = false;
        }

        color = (redColor * 65536) + (greenColor * 256) + blueColor;
        int[] array = new int[]{color};
        ClientPlayNetworking.send(HexMessages.COLOR_ID, PacketByteBufs.create().writeIntArray(array));


    }

    @Override
    public void resize(MinecraftClient client, int width, int height) {
        String string1 = this.redField.getText();
        String string2 = this.blueField.getText();
        String string3 = this.greenField.getText();
        this.init(client,width,height);
        this.redField.setText(string1);
        this.blueField.setText(string2);
        this.greenField.setText(string3);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            assert this.client != null;
            assert this.client.player != null;
            this.client.player.closeHandledScreen();
        }
        if (this.redField.keyPressed(keyCode, scanCode, modifiers) || this.blueField.keyPressed(keyCode, scanCode, modifiers)
            || this.greenField.keyPressed(keyCode, scanCode, modifiers)) {
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x , y, 0, 0, backgroundWidth, backgroundHeight);
        renderProgressArrow(context,x,y);
        renderText(context, x, y);
        renderTextBox(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y){
        boolean validPacket = true;
        if(!isValid1 || !isValid2 || !isValid3){
            context.drawTexture(TEXTURE, x + 86, y+50,176,19,22,15);
            validPacket = false;
        } else{
            validPacket = true;
        }
        ClientPlayNetworking.send(HexMessages.VALID_ID, PacketByteBufs.create().writeString(String.valueOf(validPacket)));

    }

    private void renderText(DrawContext context, int x, int y){
        int color = 3618615;
        context.drawText(textRenderer, "R", x + 13, y + 39, color, false);
        context.drawText(textRenderer, "G", x + 13, y + 50, color, false);
        context.drawText(textRenderer, "B", x + 13, y + 61, color, false);
    }
    private void renderTextBox(DrawContext context, int x, int y){
        context.drawTexture(TEXTURE, x + 21, y + 38, 0, 176, 28, 10);
        context.drawTexture(TEXTURE,x + 21, y + 49, 0, 176, 28,10);
        context.drawTexture(TEXTURE,x + 21, y + 60, 0, 176, 28,10);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX,mouseY);

        this.redField.render(context,mouseX,mouseY,delta);
        this.greenField.render(context, mouseX, mouseY, delta);
        this.blueField.render(context, mouseX, mouseY, delta);
    }
}
